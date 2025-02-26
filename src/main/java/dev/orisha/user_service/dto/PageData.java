package dev.orisha.user_service.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString(exclude = "content")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageData<T> {

    private int currentPage;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private List<T> content;

}