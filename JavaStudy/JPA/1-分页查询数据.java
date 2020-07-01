@Test
    public void DontaiFind() {
        System.out.println("开始单元测试");
        Specification<Seller> sellerSpecification = null;
        // Pageable pageable = new PageRequest(0, 2);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Seller> all = sellerDao.findAll(sellerSpecification, pageable);
        // 得到数据库中总的数据条数
        long totalElements = all.getTotalElements();
        System.out.println(totalElements);

        // 获取查询到的内容
        List<Seller> content = all.getContent();
        for (Seller seller : content) {
            String name = seller.getName();
            System.out.println(name);
        }

        // 得到总页数
        int totalPages = all.getTotalPages();
        System.out.println(totalPages);

    }
