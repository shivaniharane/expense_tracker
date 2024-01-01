package com.expenseTracker.Service;

import com.expenseTracker.Model.Expense;
import com.expenseTracker.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense findById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }
    @Override
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }
    @Override
    @Transactional
    public void updateExpense(Expense updatedExpense) {
        expenseRepository.save(updatedExpense);
    }

    @Override
    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
}



}
