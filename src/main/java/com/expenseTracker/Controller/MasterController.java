package com.expenseTracker.Controller;

import com.expenseTracker.Model.Expense;
import com.expenseTracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MasterController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "List of expenses");
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);
        return "home";
    }

    @GetMapping("/expenses")
    public String showExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expenses";
    }

    @PostMapping("/expenses")
    public String saveExpense(Expense expense) {
        expenseService.save(expense);
        return "redirect:/";
    }

    @GetMapping("/expenses/edit/{id}")
    public String showEditExpenseDetails(@PathVariable Long id, Model model) {
        Expense expense = expenseService.findById(id);
        model.addAttribute("expense", expense);
        return "editExpenseForm";
    }

    @PostMapping("/expenses/edit/{id}")
    public String editExpense(@PathVariable Long id, Expense updatedExpense) {
        updatedExpense.setId(id);
        expenseService.updateExpense(updatedExpense);
        return "redirect:/";
    }

    @GetMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return "redirect:/";
    }
}
