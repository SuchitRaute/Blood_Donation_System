package com.blooddonation.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("BloodDonationPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}