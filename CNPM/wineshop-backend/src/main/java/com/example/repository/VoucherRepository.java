package com.example.repository;

import com.example.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    // Có thể thêm phương thức tìm kiếm nếu cần, ví dụ:
    // Optional<Voucher> findByCode(String code);
}
