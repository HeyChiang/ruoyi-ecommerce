package com.ruoyi.ecommerce.service;

import java.util.List;
import com.ruoyi.ecommerce.domain.Product;

/**
 * 商品Service接口
 * 
 * @author Chiang
 * @date 2020-12-25
 */
public interface IProductService 
{
    /**
     * 查询商品
     * 
     * @param pkId 商品ID
     * @return 商品
     */
    public Product selectProductById(Long pkId);

    /**
     * 查询商品列表
     * 
     * @param product 商品
     * @return 商品集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增商品
     * 
     * @param product 商品
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改商品
     * 
     * @param product 商品
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除商品
     * 
     * @param pkIds 需要删除的商品ID
     * @return 结果
     */
    public int deleteProductByIds(Long[] pkIds);

    /**
     * 删除商品信息
     * 
     * @param pkId 商品ID
     * @return 结果
     */
    public int deleteProductById(Long pkId);
}
