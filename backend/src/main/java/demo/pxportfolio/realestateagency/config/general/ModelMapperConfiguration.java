package demo.pxportfolio.realestateagency.config.general;

import demo.pxportfolio.realestateagency.auth.role.Role;
import demo.pxportfolio.realestateagency.auth.role.RoleDto;
import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        // Set matching strategy to STRICT for better accuracy in nested object mappings
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.STRICT)
//                .setFieldMatchingEnabled(true)
//                .setSkipNullEnabled(true)
//                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
//
//        // Global converter for Set<Role> to Set<RoleDTO>
//        modelMapper.typeMap(User.class, UserDto.class).addMappings(mapper -> {
//            mapper.skip(UserDto::setRole);  // Skip the default role mapping
//        });
//
//        modelMapper.addConverter(ctx -> {
//            Set<Role> roles = ctx.getSource();
//            return roles != null ? roles.stream()
//                    .map(role -> modelMapper.map(role, RoleDto.class))
//                    .collect(Collectors.toSet()) : null;
//        }, Set.class, Set.class);

//        // Example of additional custom mappings
//
//        // Custom mapping for Order to OrderDTO
//        modelMapper.addMappings(new PropertyMap<Order, OrderDTO>() {
//            @Override
//            protected void configure() {
//                map().setOrderNumber(source.getId());
//                map().setCustomerName(source.getCustomer().getName());
//            }
//        });
//
//        // Custom mapping for Product to ProductDTO
//        modelMapper.addMappings(new PropertyMap<Product, ProductDTO>() {
//            @Override
//            protected void configure() {
//                map(source.getPrice(), destination.getCost()); // Map price to cost
//            }
//        });
//
//        // Example of handling nested mappings with specific converters
//        modelMapper.addConverter((Converter<Category, CategoryDTO>) ctx -> {
//            Category source = ctx.getSource();
//            if (source == null) {
//                return null;
//            }
//            CategoryDTO dto = new CategoryDTO();
//            dto.setId(source.getId());
//            dto.setName(source.getName());
//            // Handle nested properties if needed
//            return dto;
//        });

        return modelMapper;
    }
}
