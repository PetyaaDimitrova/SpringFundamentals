package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.offer.CreateOrUpdateOfferDTO;
import bg.softuni.mobilele.model.dto.offer.OfferDetailDTO;
import bg.softuni.mobilele.model.entity.BrandEntity;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.model.entity.UserEntity;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-06T11:42:06+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class OfferMapperImpl implements OfferMapper {

    @Override
    public OfferEntity createOrUpdateOfferDtoToOfferEntity(CreateOrUpdateOfferDTO addOfferDTO) {
        if ( addOfferDTO == null ) {
            return null;
        }

        OfferEntity offerEntity = new OfferEntity();

        offerEntity.setEngine( addOfferDTO.getEngine() );
        offerEntity.setImageUrl( addOfferDTO.getImageUrl() );
        if ( addOfferDTO.getMileage() != null ) {
            offerEntity.setMileage( addOfferDTO.getMileage() );
        }
        if ( addOfferDTO.getPrice() != null ) {
            offerEntity.setPrice( BigDecimal.valueOf( addOfferDTO.getPrice() ) );
        }
        offerEntity.setTransmission( addOfferDTO.getTransmission() );
        if ( addOfferDTO.getYear() != null ) {
            offerEntity.setYear( addOfferDTO.getYear() );
        }
        offerEntity.setDescription( addOfferDTO.getDescription() );

        return offerEntity;
    }

    @Override
    public CreateOrUpdateOfferDTO offerEntityToCreateOrUpdateOfferDtoTo(OfferEntity offerEntity) {
        if ( offerEntity == null ) {
            return null;
        }

        CreateOrUpdateOfferDTO createOrUpdateOfferDTO = new CreateOrUpdateOfferDTO();

        createOrUpdateOfferDTO.setEngine( offerEntity.getEngine() );
        createOrUpdateOfferDTO.setImageUrl( offerEntity.getImageUrl() );
        createOrUpdateOfferDTO.setTransmission( offerEntity.getTransmission() );
        if ( offerEntity.getPrice() != null ) {
            createOrUpdateOfferDTO.setPrice( offerEntity.getPrice().intValue() );
        }
        createOrUpdateOfferDTO.setYear( offerEntity.getYear() );
        createOrUpdateOfferDTO.setDescription( offerEntity.getDescription() );
        createOrUpdateOfferDTO.setMileage( offerEntity.getMileage() );

        return createOrUpdateOfferDTO;
    }

    @Override
    public OfferDetailDTO offerEntityToOfferDetailDto(OfferEntity offerEntity) {
        if ( offerEntity == null ) {
            return null;
        }

        OfferDetailDTO offerDetailDTO = new OfferDetailDTO();

        offerDetailDTO.setModel( offerEntityModelName( offerEntity ) );
        offerDetailDTO.setBrand( offerEntityModelBrandName( offerEntity ) );
        offerDetailDTO.setSellerFirstName( offerEntitySellerFirstName( offerEntity ) );
        offerDetailDTO.setSellerLastName( offerEntitySellerLastName( offerEntity ) );
        offerDetailDTO.setImageUrl( offerEntity.getImageUrl() );
        offerDetailDTO.setYear( offerEntity.getYear() );
        offerDetailDTO.setMileage( offerEntity.getMileage() );
        offerDetailDTO.setPrice( offerEntity.getPrice() );
        offerDetailDTO.setEngine( offerEntity.getEngine() );
        offerDetailDTO.setTransmission( offerEntity.getTransmission() );
        offerDetailDTO.setId( offerEntity.getId() );

        return offerDetailDTO;
    }

    private String offerEntityModelName(OfferEntity offerEntity) {
        if ( offerEntity == null ) {
            return null;
        }
        ModelEntity model = offerEntity.getModel();
        if ( model == null ) {
            return null;
        }
        String name = model.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String offerEntityModelBrandName(OfferEntity offerEntity) {
        if ( offerEntity == null ) {
            return null;
        }
        ModelEntity model = offerEntity.getModel();
        if ( model == null ) {
            return null;
        }
        BrandEntity brand = model.getBrand();
        if ( brand == null ) {
            return null;
        }
        String name = brand.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String offerEntitySellerFirstName(OfferEntity offerEntity) {
        if ( offerEntity == null ) {
            return null;
        }
        UserEntity seller = offerEntity.getSeller();
        if ( seller == null ) {
            return null;
        }
        String firstName = seller.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String offerEntitySellerLastName(OfferEntity offerEntity) {
        if ( offerEntity == null ) {
            return null;
        }
        UserEntity seller = offerEntity.getSeller();
        if ( seller == null ) {
            return null;
        }
        String lastName = seller.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }
}
