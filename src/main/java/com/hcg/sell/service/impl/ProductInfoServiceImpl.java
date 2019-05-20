package com.hcg.sell.service.impl;

import com.hcg.sell.dataObject.ProductInfo;
import com.hcg.sell.dto.CartDTO;
import com.hcg.sell.eunms.ProductStatusEunm;
import com.hcg.sell.eunms.ResultEunm;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.repository.ProductInfoRepository;
import com.hcg.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @program: sell
 * @description: 商品信息实service现类
 * @author: hcg
 * @create: 2019-05-18 18:12
 * @modify by:
 * @updated:
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findById(String id) {
        Optional<ProductInfo> optionalProductInfo = productInfoRepository.findById(id);
        if (!optionalProductInfo.isPresent()){
            throw new SellException(ResultEunm.PRODUCT_NOT_EXIST);
        }
        return optionalProductInfo.get();
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findAll();
    }

    @Override
    public Page<ProductInfo> findPageAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEunm.UP.getCode());
    }

    @Override
    public List<ProductInfo> findDownAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEunm.DOWN.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).get();
            if (productInfo==null){
                throw new SellException(ResultEunm.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).get();
            if (productInfo==null){
                throw new SellException(ResultEunm.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0){
                throw new SellException(ResultEunm.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
