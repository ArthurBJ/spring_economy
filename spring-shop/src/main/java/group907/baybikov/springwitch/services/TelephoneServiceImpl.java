package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.forms.TelephoneForm;
import group907.baybikov.springwitch.models.Telephone;
import group907.baybikov.springwitch.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelephoneServiceImpl implements TelephoneService {

    @Autowired
    private TelephoneRepository telephoneRepository;

    @Override
    public void save(TelephoneForm telephoneForm) {
        Telephone telephone = Telephone.builder()
                .tel(telephoneForm.getTel())
                .build();

        telephoneRepository.save(telephone);
    }
}
