package com.minhnh.hapedu.common.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum RoleEnum {
    CUSTOMER("customer",
            "Khách hàng",
            "Người dùng đã đăng ký là khách hàng thực tế hoặc khách hàng tiềm năng"),
    SALE("sale",
            "Nhân viên bán hàng",
            "Các thành viên bán hàng của tổ chức"),
    LECTURER("lecturer",
            "Giảng viên",
            "Truy cập và chuẩn bị nội dung khóa học/bài kiểm tra theo sự phân công của quản trị viên"),
    ADMIN("admin",
            "Quản trị viên",
            "Người lãnh đạo/quản lý tổ chức, đóng vai trò là người quản trị hệ thống");

    private final String code;
    private final String name;
    private final String description;

    RoleEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public static RoleEnum getByCode(String code) {
        for (RoleEnum roleEnum : values()) {
            if (roleEnum.getCode().equalsIgnoreCase(code)) {
                return roleEnum;
            }
        }
        return null;
    }

    public static List<String> getInitCodes() {
        List<String> codes = new ArrayList<>();
        for (RoleEnum roleEnum : values()) {
            codes.add(roleEnum.getCode());
        }
        return codes;
    }
}
