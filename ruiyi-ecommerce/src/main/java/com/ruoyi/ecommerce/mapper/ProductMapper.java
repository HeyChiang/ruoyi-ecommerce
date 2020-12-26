package com.ruoyi.ecommerce.mapper;

import java.util.List;
import com.ruoyi.ecommerce.domain.Product;

/**
 * 商品Mapper接口
 * 
 * @author Chiang
 * @date 2020-12-25
 */
public interface ProductMapper 
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
     * 删除商品
     * 
     * @param pkId 商品ID
     * @return 结果
     */
    public int deleteProductById(Long pkId);

    /**
     * 批量删除商品
     * 
     * @param pkIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductByIds(Long[] pkIds);
}
