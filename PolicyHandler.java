package com.functional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Policy
{
    String policyNumber;
    String holderName;
    String premiumAmount;

    public Policy(String policyNumber, String holderName, String premiumAmount){
        this.policyNumber=policyNumber;
        this.premiumAmount=premiumAmount;
        this.holderName=holderName;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", premiumAmount='" + premiumAmount + '\'' +
                '}';
    }
}

public class PolicyHandler {

    public static void main(String[] args) {

        List<Policy> policyData = new ArrayList<>();
        policyData.add(new Policy("101", "Poojitha", "50000"));
        policyData.add(new Policy("103", "Pranathi", "45000"));
        policyData.add(new Policy("102", "Harshi", "1500"));
        policyData.add(new Policy("105", "Nisha", "42000"));

        List<Policy> policyFilter = policyData.stream()
                .filter(policy -> {
                    try {
                        return Integer.parseInt(policy.premiumAmount) > 1200;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println("filtering policies by premium amount:");
        policyFilter.forEach(policy -> System.out.println(policy.policyNumber + " - " + policy.holderName + " - " + policy.premiumAmount));

        List<Policy> sortByHolderName=policyData.stream().sorted(Comparator.comparing(Policy::getHolderName)).collect(Collectors.toList());
        System.out.println("\nSorted by holder name:\n "+sortByHolderName);

        double totalPremium = policyData.stream().mapToDouble(policy -> Double.parseDouble(policy.premiumAmount)).sum();
        System.out.println("\ntotal premium amount:\n "+totalPremium);

        System.out.println("\nPolicy details: ");
        policyData.forEach(policy -> System.out.println(policy.policyNumber + " - " + policy.holderName + " - " + policy.premiumAmount));

        List<Policy> filterByPremiumRange = policyData.stream()
                .filter(policy -> {
                    double premium = Double.parseDouble(policy.premiumAmount);
                    return premium >= 1000 && premium <= 2000;
                })
                .collect(Collectors.toList());

        System.out.println("\nFiltered policies by premium range (1000 to 2000):");
        for (Policy policy : filterByPremiumRange) {
            System.out.println(policy);
        }

        System.out.println("\npolicy with Highest premium:");
        policyData.stream().max(Comparator.comparingDouble(policy -> Double.parseDouble(policy.premiumAmount))).ifPresent(policy -> System.out.println(policy.policyNumber));

        Map<Character, List<Policy>> groupedByInitial = policyData.stream().collect(Collectors.groupingBy(policy -> policy.holderName.charAt(0)));
        System.out.println("\ngrouping by Holder name initial:");
        System.out.println(groupedByInitial);

        double averagePremium = policyData.stream().mapToDouble(policy -> Double.parseDouble(policy.premiumAmount)).average().orElse(0);
        System.out.println("\ncalculating avg premium:");
        System.out.println(averagePremium);

        System.out.println("\nSorting policies by premium:");
        policyData.stream().sorted(Comparator.comparingDouble(policy -> Double.parseDouble(policy.premiumAmount))).forEach(policy -> System.out.println(policy.policyNumber + " - " + policy.premiumAmount));

        boolean anyPolicyExceeds2000 = policyData.stream().anyMatch(policy -> Double.parseDouble(policy.premiumAmount) > 2000);
        System.out.println("\nchecking policies that exceeds 2000:");
        System.out.println(anyPolicyExceeds2000);

        Map<String, Long> premiumRangeCount = policyData.stream().collect(Collectors.groupingBy(policy -> {
            double premium = Double.parseDouble(policy.premiumAmount);
            if (premium <= 1000) return "$0-$1000";
            else if (premium <= 2000) return "$1001-$2000";
            else return ">$2000";
        }, Collectors.counting()));
        System.out.println("\ncounting premium count range: ");
        System.out.println(premiumRangeCount);

        System.out.println("\nunique holder names:");
        List<String> distinctHolderNames = policyData.stream()
                .map(policy -> policy.holderName)
                .distinct()
                .collect(Collectors.toList());

        for (String holderName : distinctHolderNames) {
            System.out.println(holderName);
        }

        List<Policy> holderNameSubstr = policyData.stream()
                .filter(policy -> policy.holderName.contains("Pooji"))
                .collect(Collectors.toList());
        System.out.println("\nPolicies with holder names containing:");
        for (Policy policy : holderNameSubstr) {
            System.out.println(policy);
        }

        Map<String, Double> policyMap = policyData.stream().collect(Collectors.toMap(policy -> policy.policyNumber, policy -> Double.parseDouble(policy.premiumAmount)));
        System.out.println("\ncreating Map of Policy Numbers to Premium Amounts");
        System.out.println(policyMap);

        String text = "this is the text to find again and again texted text";
        List<String> topWords = Arrays.stream(text.split("\\W+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("\nFrequent words:");
        System.out.println(topWords);

        List<String> words = Arrays.asList("this", "is", "a", "test", "test", "test");
        String secondMostFrequentWord = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("No second most frequent word");
        System.out.println("\nSecond most repeated word :");
        System.out.println(secondMostFrequentWord);
    }
}