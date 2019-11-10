package kindgeek.middlepost.specification;

import kindgeek.middlepost.dto.request.FilterWorkerRequest;
import kindgeek.middlepost.entityes.Worker;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class WorkerSpecification implements Specification<Worker> {

    private FilterWorkerRequest filterWorkerRequest;

    public WorkerSpecification(FilterWorkerRequest filterWorkerRequest){
        this.filterWorkerRequest = filterWorkerRequest;
    }

    private Predicate filterByPSalary(Root<Worker> root, CriteriaBuilder criteriaBuilder){
        if(filterWorkerRequest.getSalaryFrom() != null & filterWorkerRequest.getSalaryTo() != null){
            return criteriaBuilder.between(root.get("salary"), filterWorkerRequest.getSalaryFrom(), filterWorkerRequest.getSalaryTo());
        } else {
            return criteriaBuilder.conjunction();
        }
    }

    @Override
    public Predicate toPredicate(Root<Worker> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(filterByPSalary(root, criteriaBuilder));
    }
}
