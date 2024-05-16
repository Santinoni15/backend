package com.example.atv6.repositories;

import com.example.atv6.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, UUID> {
}
