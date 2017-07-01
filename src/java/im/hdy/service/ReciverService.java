package im.hdy.service;

import im.hdy.dao.ReciverDao;
import im.hdy.model.ReciverEntity;
import im.hdy.rsa.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by hdy on 2017/6/28.
 */
@Service
@Transactional
public class ReciverService {

    @Autowired
    private ReciverDao reciverDao;

    public ReciverEntity addReciver(ReciverEntity entity) {
        ReciverEntity save = reciverDao.save(entity);
        return save;
    }

    //不能进行任何修改
    public void updateReciver(ReciverEntity entity) {

    }


    public void delReciver(Integer id) {
        reciverDao.delete(id);
    }

    public List<ReciverEntity> getReciver(final Long id, int page) {
        PageRequest request = new PageRequest(page, Constants.RECIVER_SERVICE_QUERT_NUM);
        Page<ReciverEntity> all = reciverDao.findAll(new Specification<ReciverEntity>() {
            public Predicate toPredicate(Root<ReciverEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Root<ReciverEntity> entityRoot = criteriaQuery.from(ReciverEntity.class);
                Expression<Long> longId = entityRoot.get("userid").as(Long.class);
                Predicate predicate = criteriaBuilder.equal(longId, id);
                return predicate;
            }
        }, request);
        if (all == null) {
            return null;
        }
        return all.getContent();
    }

}
