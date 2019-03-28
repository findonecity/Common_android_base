package com.example.common_android_base.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zj on 2019/3/25.
 * is use for: 测试登录model
 */
public class LoginBean implements Serializable {
        private int id;
        private String login_name;
        private String real_name;
        private String role_name;
        private String roleid;
        private String type;
        private String token;
        private List<MenusBean> menus;
        private List<String> powers;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin_name() {
            return login_name;
        }

        public void setLogin_name(String login_name) {
            this.login_name = login_name;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getRole_name() {
            return role_name;
        }

        public void setRole_name(String role_name) {
            this.role_name = role_name;
        }

        public String getRoleid() {
            return roleid;
        }

        public void setRoleid(String roleid) {
            this.roleid = roleid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<MenusBean> getMenus() {
            return menus;
        }

        public void setMenus(List<MenusBean> menus) {
            this.menus = menus;
        }

        public List<String> getPowers() {
            return powers;
        }

        public void setPowers(List<String> powers) {
            this.powers = powers;
        }

        public static class MenusBean {
            /**
             * menu_id : 1
             * menu_name : 订单管理
             * url : /orderManege
             * menu_code : 001
             * father_id : 0
             */

            private int menu_id;
            private String menu_name;
            private String url;
            private String menu_code;
            private int father_id;

            public int getMenu_id() {
                return menu_id;
            }

            public void setMenu_id(int menu_id) {
                this.menu_id = menu_id;
            }

            public String getMenu_name() {
                return menu_name;
            }

            public void setMenu_name(String menu_name) {
                this.menu_name = menu_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getMenu_code() {
                return menu_code;
            }

            public void setMenu_code(String menu_code) {
                this.menu_code = menu_code;
            }

            public int getFather_id() {
                return father_id;
            }

            public void setFather_id(int father_id) {
                this.father_id = father_id;
            }
        }
}
