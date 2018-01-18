package com.codeup.springbootblog.lessonIntro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    private int counter = 0;

    @GetMapping("/roll-dice")
    public String showRollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String play(@PathVariable int guess, Model viewModel) {


        int random = (int)(Math.random() * 6 + 1);
        counter++;


        viewModel.addAttribute("guess", guess);
        viewModel.addAttribute("random", random);
        viewModel.addAttribute("counter", counter);

        if(guess == random) {

            counter = 0;

        }
        return "roll-dice";
    }











}
