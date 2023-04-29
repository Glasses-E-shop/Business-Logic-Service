package com.test.servicies;

import com.test.dto.ClientDTO;
import com.test.entities.Client;
import com.test.exceptions.InvalidInputException;
import com.test.exceptions.NotFoundException;
import com.test.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepo clientRepo;

    public Client add (ClientDTO clientDTO) throws InvalidInputException {
        Client x = new Client(
                clientDTO.getUsername(),
                clientDTO.getPassword(),
                clientDTO.getGender(),
                clientDTO.getAge());
        if(clientDTO.getAge() < 0 || clientDTO.getAge() > 99) {
            throw new InvalidInputException("Varsta nu este valabila");
        }
        return this.clientRepo.save(x);
    }

    public List<Client> getClients() throws NotFoundException {
        List<Client> check = this.clientRepo.findAll();
        if(check.isEmpty()) {
            throw new NotFoundException("Nu au fost gasiti clienti");
        }
        return check;
    }
    public Optional<Client> getClient(int id) throws NotFoundException {
        if(this.clientRepo.findById(id).isEmpty()) {
            throw new NotFoundException("Nu exista client cu acest id");
        }
        return this.clientRepo.findById(id) ;
    }
    public void delClient(int id) {
        this.clientRepo.deleteById(id);
    }
}
