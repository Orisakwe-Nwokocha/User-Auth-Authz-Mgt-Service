package dev.orisha.user_service.factory;

import dev.orisha.user_service.dto.PageData;
import dev.orisha.user_service.dto.UserDTO;
import org.springframework.data.domain.Page;

public class RequestFactory {

    private RequestFactory() {}

    public static PageData<UserDTO> createPageData(Page<UserDTO> userDTOsPage) {
        PageData<UserDTO> dtoPage = new PageData<>();
        dtoPage.setCurrentPage(userDTOsPage.getNumber());
        dtoPage.setTotalPages(userDTOsPage.getTotalPages());
        dtoPage.setTotalElements(userDTOsPage.getTotalElements());
        dtoPage.setPageSize(userDTOsPage.getSize());
        dtoPage.setContent(userDTOsPage.getContent());
        return dtoPage;
    }

}
