package com.example.assignment.products.product.manager;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.vo.Money;
import com.example.assignment.products.domains.*;
import com.example.assignment.products.product.dto.ProductItemAddDto;
import com.example.assignment.products.product.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductItemManager {

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductOptionRepository productOptionRepository;
    private final OptionValueRepository optionValueRepository;
    private final ProductItemRepository productItemRepository;

    @Transactional
    public Long saveProductItem(ProductItemAddDto.Request request) {
        Long productId = request.getProductId();
        Long productDetailId = request.getProductDetailId();
        Long productOptionId = request.getProductOptionId();
        Long optionValueId = request.getOptionValueId();

        String stockKeepingUnitCode = makeUnitCode(productId, productDetailId, productOptionId, optionValueId);

        ProductItem productItem = ProductItem.builder()
                .productItemId(request.getProductId())
                .stockKeepingUnitCode(stockKeepingUnitCode)
                .productId(productId)
                .price(Money.of(request.getPrice()))
                .stock(request.getStock())
                .expireDate(request.getExpireDate())
                .build();

        return productItemRepository.save(productItem).getProductItemId();
    }

    public String makeUnitCode(Long productId, Long productDetailId, Long productOptionId, Long optionValueId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_NOT_FOUND, productId));

        ProductDetail productDetail = productDetailRepository.findById(productDetailId)
                .orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_DETAIL_NOT_FOUND, productDetailId));

        ProductOption productOption = productOptionRepository.findById(productOptionId)
                .orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_OPTION_NOT_FOUND, productOptionId));

        OptionValue optionValue = optionValueRepository.findById(optionValueId)
                .orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_OPTION_VALUE_NOT_FOUND, optionValueId));

        return String.format("%s-%s-%s", productDetail.getProductType(), productOption.getCode(), optionValue.getCode());
    }
}
