package com.example.expensetracker.models.enums;

import com.example.expensetracker.models.enums.expenseCategories.Financials;
import com.example.expensetracker.models.enums.expenseCategories.Living;
import com.example.expensetracker.models.enums.expenseCategories.Mobility;
import com.example.expensetracker.models.enums.expenseCategories.Multimedia;
import com.example.expensetracker.models.enums.expenseCategories.SelfPreservation;

public enum ExpenseType {

    LIVING {
        public Living getElectricity() {
            return Living.ELECTRICITY;
        }

        public Living getRent() {
            return Living.RENT;

        }

        public Living getInternet() {
            return Living.INTERNET;
        }

        public Living getPhone() {
            return Living.PHONE;
        }
    },
    MOBILITY{
        public Mobility getPublicTransportation(){
            return Mobility.PUBLIC_TRANSPORTATION;
        }

        public Mobility getGasoline() {
            return Mobility.GASOLINE;
        }

        public Mobility getTaxi() {
            return Mobility.TAXI;
        }
    },
    SELF_PRESERVATION {
        public SelfPreservation getGroceries() {
            return SelfPreservation.GROCERIES;
        }

        public SelfPreservation getOutsideFood() {
            return SelfPreservation.OUTSIDE_FOOD;
        }
        public SelfPreservation getShoppign() {
            return SelfPreservation.SHOPPING;
        }
        public SelfPreservation getEducation() {
            return SelfPreservation.EDUCATION;
        }
        public SelfPreservation getCoffeur() {
            return SelfPreservation.COFFEUR;
        }

        public SelfPreservation getSports() {
            return SelfPreservation.SPORTS;
        }


    },
    ENTERTAINMENT,
    MULTIMEDIA {
        public Multimedia getNetflix() {
            return Multimedia.NETFLIX;
        }
        public Multimedia getDazn() {
            return Multimedia.DAZN;
        }
        public Multimedia getDisney() {
            return Multimedia.DISNEY;
        }
        public Multimedia getAmazonPrime() {
            return Multimedia.AMAZON_PRIME;
        }
        public Multimedia getMobile() {
            return Multimedia.MOBILE;
        }
    },
    FINANCIAL {
        public Financials getDebts() {
            return Financials.DEBTS;
        }
        public Financials getInsurance() {
            return Financials.INSURANCE;
        }
        public Financials getInvestments() {
            return Financials.INVESTMENTS;
        }
        public Financials getLoans() {
            return Financials.LOANS;
        }
    };
}
