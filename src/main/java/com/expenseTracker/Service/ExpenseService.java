package com.expenseTracker.Service;

import com.expenseTracker.Model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
     List<Expense> findAll();

     Expense save(Expense expense);

     Expense findById(Long id);

     void updateExpense(Expense updatedExpense);

     void deleteById(Long id);


}
