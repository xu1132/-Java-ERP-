package com.xuyi.controller;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.Customer;
import com.xuyi.service.CustomerService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xuyi
 * @date 2024/10/25 9:00
 * @description 客户Controller控制器
 * 声明了一个RestController注解，表示这个类是一个RESTful风格的控制器，用于处理HTTP请求和响应。
 * 声明了一个RequestMapping注解，指定了映射路径"/customer"，表示处理的请求路径都以"/customer"开头。
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired//声明了一个@Autowired注解，用于自动注入CustomerService对象。
    private CustomerService customerService;

    /**
     * 查询下拉框客户信息
     * @param q 客户名称
     * @return
     * 定义了一个方法"getComboboxList"，使用RequestMapping注解指定了映射路
     * 径"/getComboboxList"，表示处理的请求路径是"/customer/getComboboxList"。
     * 该方法需要满足"销售出库"、"客户退货"、"销售单据查询"、"客户退货查询"、"客户统计"
     * 中任意一种权限才能调用。方法接收一个名为"q"的参数，表示客户名称，
     * 返回一个List<Customer>类型的结果。
     * 这段代码中使用了Apache Shiro框架的权限控制注解@RequiresPermissions来设置权限。
     * logical属性指定了权限之间的逻辑关系，这里使用了Logical.OR表示逻辑关系为"或"，即满足其中一个权限即可。
     */
    @RequestMapping("/getComboboxList")
    @RequiresPermissions(value={"销售出库","客户退货","销售单据查询","客户退货查询","客户统计"},logical= Logical.OR)
    public List<Customer> getComboboxList(String q) {
        return customerService.getComboboxList(q);
    }

    /**
     * 分页查询客户
     * @param page 当前页数
     * @param rows 每页显示的记录数
     * @param customerName 客户名
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "客户管理")// 有客户管理菜单权限的才给予调用
    public Map<String,Object> list(Integer page, Integer rows, String customerName) {
        return customerService.list(page, rows, customerName);
    }

    /**
     * 添加或修改客户
     * @param customer 客户实体
     * @return
     * 定义了一个方法"save"，使用RequestMapping注解指定了映射路径"/save"，
     * 表示处理的请求路径是"/customer/save"。
     * 该方法需要满足"客户管理"的权限才能调用。
     * 方法接收一个Customer类型的参数"customer"，表示客户实体，返回一个ServiceVO类型的结果。
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "客户管理")
    public ServiceVO save(Customer customer) {
        return customerService.save(customer);
    }

    /**
     * 删除客户
     * @param ids 客户ids字符串，用逗号分隔
     * @return
     * 定义了一个方法"delete"，使用RequestMapping注解指定了映射路径"/delete"，
     * 表示处理的请求路径是"/customer/delete"。
     * 该方法需要满足"客户管理"的权限才能调用。
     * 方法接收一个名为"ids"的参数，表示客户ids字符串，多个id用逗号分隔，
     * 返回一个ServiceVO类型的结果
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "客户管理")
    public ServiceVO delete(String ids) {
        return customerService.delete(ids);
    }
}
