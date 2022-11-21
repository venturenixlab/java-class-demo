package com.vtxlab.demo.stock.repository;

import org.springframework.stereotype.Repository;

import com.vtxlab.demo.stock.entity.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
