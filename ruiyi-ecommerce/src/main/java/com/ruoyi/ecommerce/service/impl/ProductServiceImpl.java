package com.ruoyi.ecommerce.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ecommerce.mapper.ProductMapper;
import com.ruoyi.ecommerce.domain.Product;
import com.ruoyi.ecommerce.service.IProductService;

/**
 * 商品Service业务层处理
 * 
 * @author Chiang
 * @date 2020-12-25
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品
     * 
     * @param pkId 商品ID
     * @return 商品
     */
    @Override
    public Product selectProductById(Long pkId)
    {
        return productMapper.selectProductById(pkId);
    }

    /**
     * 查询商品列表
     * 
     * @param product 商品
     * @return 商品
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品
     * 
     * @param product 商品
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品
     * 
     * @param product 商品
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        product.setUpdateTime(DateUtils.getNowDate());
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除商品
     * 
     * @param pkIds 需要删除的商品ID
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] pkIds)
    {
        return productMapper.deleteProductByIds(pkIds);
    }

    /**
     * 删除商品信息
     * 
     * @param pkId 商品ID
     * @return 结果
     */
    @Override
    public int deleteProductById(Long pkId)
    {
        return productMapper.deleteProductById(pkId);
    }
}
