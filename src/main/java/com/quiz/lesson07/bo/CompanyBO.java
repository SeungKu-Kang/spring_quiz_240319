package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// input : Controller로 부터 4개의 파라미터 
	// output: 새로 만들어진 CompanyEntity
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		
		// 1)
//		CompanyEntity company = CompanyEntity.builder()
//				.name(name)
//				.business(business)
//				.scale(scale)
//				.headcount(headcount)
//				.build();
//		
//		return companyRepository.save(company);
		
		// 2)
		return companyRepository.save(CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	// 3)
	// input : id , scale , headcount
	// output: companyEntity
	public CompanyEntity updateCompanyScaleHeadcountById(int id, String scale, int headcount) {
		// 기존 데이터 조회 => CompanyEntity
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// Entity의 데이터 값을 변경
		if (company != null) {
			companyRepository.save(company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build());
		}
		// update
		return company;
	}
	
	// 4)
	// input: id
	// output : X
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyEntity = companyRepository.findById(id);
		companyEntity.ifPresent(c -> companyRepository.delete(c));
		
	}
}
