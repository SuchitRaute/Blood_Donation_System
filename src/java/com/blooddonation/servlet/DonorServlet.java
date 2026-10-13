package com.blooddonation.servlet;

import com.blooddonation.entity.BloodDonation;
import com.blooddonation.entity.Donor;
import com.blooddonation.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/DonorServlet")
public class DonorServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String bloodGroup = request.getParameter("bloodGroup");

        String ageText = request.getParameter("age");
        String donationDateText =
                request.getParameter("donationDate");

        String bloodUnitsText =
                request.getParameter("bloodUnits");

        String donationType =
                request.getParameter("donationType");


        // NAME VALIDATION

        if (name == null ||
            name.trim().length() < 2) {

            response.getWriter().println(
                    "Invalid name"
            );

            return;
        }


        // EMAIL VALIDATION

        if (email == null ||
            !email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            response.getWriter().println(
                    "Invalid email"
            );

            return;
        }


        // PHONE VALIDATION

        if (phone == null ||
            !phone.matches("[0-9]{10}")) {

            response.getWriter().println(
                    "Phone number must contain 10 digits"
            );

            return;
        }


        // AGE VALIDATION

        int age;

        try {

            age = Integer.parseInt(ageText);

        } catch (Exception e) {

            response.getWriter().println(
                    "Invalid age"
            );

            return;
        }

        if (age < 18 || age > 65) {

            response.getWriter().println(
                    "Age must be between 18 and 65"
            );

            return;
        }


        // DONATION DATE

        LocalDate donationDate;

        try {

            donationDate =
                    LocalDate.parse(donationDateText);

        } catch (Exception e) {

            response.getWriter().println(
                    "Invalid donation date"
            );

            return;
        }


        // BLOOD UNITS

        double bloodUnits;

        try {

            bloodUnits =
                    Double.parseDouble(bloodUnitsText);

        } catch (Exception e) {

            response.getWriter().println(
                    "Invalid blood units"
            );

            return;
        }

        if (bloodUnits <= 0) {

            response.getWriter().println(
                    "Blood units must be greater than 0"
            );

            return;
        }


        // CREATE ENTITY MANAGER

        EntityManager em =
                JPAUtil
                    .getEntityManagerFactory()
                    .createEntityManager();

        EntityTransaction transaction =
                em.getTransaction();


        try {

            transaction.begin();


            // CREATE DONOR

            Donor donor = new Donor();

            donor.setName(name.trim());
            donor.setEmail(email.trim());
            donor.setPhone(phone.trim());
            donor.setBloodGroup(bloodGroup);
            donor.setAge(age);


            // CREATE BLOOD DONATION

            BloodDonation donation =
                    new BloodDonation();

            donation.setDonationDate(donationDate);
            donation.setBloodUnits(bloodUnits);
            donation.setDonationType(donationType);


            // ESTABLISH JPA RELATIONSHIP

            donor.addDonation(donation);


            // SAVE DONOR AND DONATION

            em.persist(donor);


            transaction.commit();


            // REDIRECT TO SUCCESS PAGE

            response.sendRedirect("success.jsp");


        } catch (Exception e) {

            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();

            response.getWriter().println(
                    "Database Error: "
                    + e.getMessage()
            );

        } finally {

            em.close();
        }
    }
}