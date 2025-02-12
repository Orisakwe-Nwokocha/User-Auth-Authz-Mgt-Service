package dev.orisha.user_service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString(exclude = "content")
public class PageData<T> {

    private int currentPage;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private List<T> content;

}
