package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BrowserHistory {
    private LinkedList<String> history;
    private ListIterator<String> iterator;
    private String current;

    public BrowserHistory() {
        history = new LinkedList<>();
        iterator = history.listIterator();
    }

    public void visit(String url) {
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        iterator.add(url);
        current = url;
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (iterator.hasPrevious()) {
            current = iterator.previous();
            System.out.println("Back to: " + current);
        } else {
            System.out.println("No previous page.");
        }
    }

    public void forward() {
        if (iterator.hasNext()) {
            current = iterator.next();
            System.out.println("Forward to: " + current);
        } else {
            System.out.println("No forward page.");
        }
    }

    public void showHistory() {
        System.out.println("Browser History:");
        for (String url : history) {
            System.out.println(url);
        }
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter command: visit <url>, back, forward, history, or exit:");
            String command = scanner.nextLine();
            if (command.startsWith("visit")) {
                String url = command.split(" ")[1];
                browserHistory.visit(url);
            } else if (command.equals("back")) {
                browserHistory.back();
            } else if (command.equals("forward")) {
                browserHistory.forward();
            } else if (command.equals("history")) {
                browserHistory.showHistory();
            } else if (command.equals("exit")) {
                System.out.println("Exiting browser...");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
        
        scanner.close();
    }
}
