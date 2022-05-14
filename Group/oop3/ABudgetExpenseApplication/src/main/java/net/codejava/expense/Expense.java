package net.codejava.expense;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import net.codejava.category.Category;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@Column(nullable=false)
	private Date expenseDate;
	
	private  float expenseAmount;
	
	
	
	private float Total;
	
	
	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	@ManyToOne
	@JoinColumn(name= "category_id")
	private Category category;
	
	private String expenseNote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public float getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(float expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getExpenseNote() {
		return expenseNote;
	}

	public void setExpenseNote(String expenseNote) {
		this.expenseNote = expenseNote;
	}
	
	
	
	
}
