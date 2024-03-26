package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository extends CSVRepository<Client> {

    public ClientRepository() {
        super("data/clients");
    }

    @Override
    protected Client createNewResource() {
        return new Client();
    }
}
