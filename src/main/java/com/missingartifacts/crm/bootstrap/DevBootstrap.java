package com.missingartifacts.crm.bootstrap;

import com.missingartifacts.crm.model.Activity;
import com.missingartifacts.crm.model.Contact;
import com.missingartifacts.crm.model.Customer;
import com.missingartifacts.crm.model.Vessel;
import com.missingartifacts.crm.repository.ActivityRepository;
import com.missingartifacts.crm.repository.ContactRepository;
import com.missingartifacts.crm.repository.CustomerRepository;
import com.missingartifacts.crm.repository.VesselRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerRepository customerRepository;
    private VesselRepository vesselRepository;
    private ContactRepository contactRepository;
    private ActivityRepository activityRepository;

    public DevBootstrap(CustomerRepository customerRepository, VesselRepository vesselRepository, ContactRepository contactRepository, ActivityRepository activityRepository) {
        this.customerRepository = customerRepository;
        this.vesselRepository = vesselRepository;
        this.contactRepository = contactRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Customer customer = new Customer("ABC Shipping");
        customer.setOriginCity("Hamburg");
        customer.setOriginCountry("Germany");
        customer.setEmail("info@abc.com");
        customer.setWeb("www.abc.com");

        Vessel vessel = new Vessel("Konstanz","Crude Oil Tanker");
        vessel.setCustomer(customer);

        Contact contact1 = new Contact("Mr","Michael","Schumacher","Purchasing Manager","michael@abc.com", customer);
        Activity activity = new Activity(new Timestamp(System.currentTimeMillis()), "Activity 1", "Email",contact1,customer);
        contact1.getActivityList().add(activity);

        customer.getVessels().add(vessel);
        customer.getContactList().add(contact1);
        customerRepository.save(customer);
        vesselRepository.save(vessel);
        contactRepository.save(contact1);
        activityRepository.save(activity);

        Customer customer2 = new Customer("Katamaran Shipping");
        customer2.setOriginCity("Copenhagen");
        customer2.setOriginCountry("Denmark");
        customer2.setEmail("info@katamara.com");
        customer2.setWeb("www.katamaran.com");


        Contact contact2 = new Contact("Mrs","Andrea","Rasmussen","Technical Manager","andrea@katamaran.com", customer2);
        Activity activity1 = new Activity(new Timestamp(System.currentTimeMillis()), "Activity 1", "Phone",contact2,customer2);
        contact2.getActivityList().add(activity1);

        Vessel vessel2 = new Vessel("Sea Bird","Container");
        vessel2.setCustomer(customer2);
        customer2.getVessels().add(vessel2);
        customer.getContactList().add(contact1);

        customerRepository.save(customer2);
        vesselRepository.save(vessel2);
        contactRepository.save(contact2);
        activityRepository.save(activity1);
    }
}
