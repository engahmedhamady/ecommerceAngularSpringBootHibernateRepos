
package com.store.bll.managers;

import com.store.beans.ProductsBean;
import java.util.List;

public interface ProductsManager {
  List< ProductsBean>  listAllProducts();
    ProductsBean findProductById(int Id);
     List< ProductsBean>  listProductsByCategory(Integer Id);
       List< ProductsBean>  listProductsByContain(String name);
}
