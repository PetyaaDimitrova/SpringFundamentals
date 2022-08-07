package bg.softuni.mobilelle.mobilelle.services;

import bg.softuni.mobilelle.mobilelle.model.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {
    List<BrandViewModel> getAllBrands();
}
