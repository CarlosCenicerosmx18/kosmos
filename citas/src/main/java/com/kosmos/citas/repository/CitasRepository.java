package com.kosmos.citas.repository;
import com.kosmos.citas.model.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {
}