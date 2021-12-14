package com.example.feemanagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.university.feemanagement.entities.Fee;
import com.university.feemanagement.repositories.FeeRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
@Rollback(true)
class FeeTestCase {

	@Autowired
	private FeeRepository repo;
	
	@Test
	@Order(1)
	void testCreateFee() {
		Fee f=new Fee(9,"Tuition","B.Tech", "2021-12-31", 70000);
		Fee savedFee=repo.save(f);
	    Assertions.assertNotNull(savedFee);
	}
	
	@Test
	@Order(2)
	void testFindFeeByNameExit() {
		String name="Canteen";
		Fee fee=repo.findByFeeName(name);
		assertThat(fee.getFeeName()).isEqualTo(name);
	}
	
	@Test
	@Order(3)
	void testGetFeeById() {
		int id=1;
		Optional<Fee> list=repo.findById(id);
		Fee f = null;
		if(list.isPresent()) {
			f = list.get();
		}
		assertThat(f.getFeeId()).isEqualTo(id);
	}
		
	
	@Test
	@Order(4)
	void testListFees() {
		List<Fee> fees=(List<Fee>)repo.findAll();
		assertThat(fees.size()).isPositive();
	}
	
	@Test
	@Order(5)
	void testDeleteFees() {
		int id=1;
		boolean isExistBeforeDelete=repo.findById(id).isPresent();
		repo.deleteById(id);
		boolean notExistAfterDelete=repo.findById(id).isPresent();
		Assertions.assertTrue(isExistBeforeDelete);
		Assertions.assertFalse(notExistAfterDelete);
	}

	
}