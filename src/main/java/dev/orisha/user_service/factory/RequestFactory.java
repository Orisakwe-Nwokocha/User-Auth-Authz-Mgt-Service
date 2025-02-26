package dev.orisha.user_service.factory;

import dev.orisha.user_service.dto.PageData;
import org.springframework.data.domain.Page;

public class RequestFactory {

    private RequestFactory() {}

    public static <T> PageData<T> createPageData(Page<T> page) {
        PageData<T> pageData = new PageData<>();
        pageData.setCurrentPage(page.getNumber());
        pageData.setPageSize(page.getSize());
        pageData.setTotalPages(page.getTotalPages());
        pageData.setTotalElements(page.getTotalElements());
        pageData.setContent(page.getContent());
        return pageData;
    }

    public static <T> PageData<T> buildPageData(Page<T> page) {
        return PageData.<T>builder()
                .currentPage(page.getNumber())
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .content(page.getContent())
                .build();
    }



}
