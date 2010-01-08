package org.d4d30.address;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("addressRepository")
@Transactional(readOnly = true)
public class AddressRepositoryImpl extends JpaDaoSupport implements AddressRepository {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void add(Address address) {
        getJpaTemplate().persist(address);

        List<Address> addresses = getJpaTemplate().findByNamedQuery("findAllAddresses");
        for(Address b : addresses) {
            System.out.println("b = " + b);
        }
    }

}
