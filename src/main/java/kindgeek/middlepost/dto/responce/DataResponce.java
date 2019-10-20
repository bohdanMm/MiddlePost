package kindgeek.middlepost.dto.responce;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataResponce<T> {

    private List<T> data = new ArrayList<>();

    private Integer page;

    private Integer size;

    private Long totalEl;

    public DataResponce(List<T> data, Page page) {
        this.data = data;
        this.size = page.getSize();
        this.page = page.getNumber();
        this.totalEl = page.getTotalElements();
    }

}
