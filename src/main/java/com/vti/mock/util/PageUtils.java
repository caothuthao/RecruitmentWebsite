package com.vti.mock.util;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class PageUtils {

    private PageUtils() {
    }

    public static void pagination(Page page, Model model) {
        int limit = 7;
        int current = page.getPageable().getPageNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + limit - 1, page.getTotalPages());
        int totalPage = page.getTotalPages();
        model.addAttribute("currentIndex", current);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("totalCount", page.getTotalElements());
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("limit", limit);
    }

}
