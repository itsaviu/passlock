package com.uas.passlock.repo;

import com.uas.passlock.models.entity.PassVault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassVaultRepository extends JpaRepository<PassVault, Long> {
}
