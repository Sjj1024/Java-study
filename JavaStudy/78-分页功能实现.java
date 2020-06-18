package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoimpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.PageService;

import java.util.List;

public class PageServiceimpl implements PageService {
    // 创建一个公用的RouteDao对象
    private RouteDao route = new RouteDaoimpl();

    @Override
    public int findTotalCount(int cid) {
        int count = route.findTotalCount(cid);
        System.out.println("查询到的总数是:" + count);
        return count;
    }

    @Override
    public PageBean<Route> findByPage(int cid, int currentpage, int pagesize) {
        System.out.println("查询单页面上旅游路线集合");
        PageBean<Route> pageBean = new PageBean<Route>();
        pageBean.setCurrentPage(currentpage);
        pageBean.setPageSize(pagesize);
        int totalCount = route.findTotalCount(cid);
        pageBean.setTotalCount(totalCount);
        // 查询总的页数
        int totalPage = totalCount % pagesize == 0 ? totalCount / pagesize : (totalCount / pagesize) + 1;
        pageBean.setTotalPage(totalPage);
        // 设置开始从哪开始查询
        int start = (currentpage - 1) * pagesize;
        List<Route> byPage = route.findByPage(cid, start, pagesize);
        // 查询完之后，将数据存储到pageBean中
        pageBean.setList(byPage);
        System.out.println("查询到了");
        return pageBean;
    }

    @Override
    public Route findById() {
        return null;
    }
}
