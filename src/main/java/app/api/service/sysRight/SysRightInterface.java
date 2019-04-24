package app.api.service.sysRight;

import java.util.List;

public interface SysRightInterface {

    class Controller{
        private Integer id;
        private String name;
        private String matchUrl;
        private Boolean sysHas;
        private String memo;
        private String menuUrl;
        private Integer sort;
        private String domain;
        private String domainDisplayName;
        private String model;
        private List<Method> methods;

        public String getDomainDisplayName() {
            return domainDisplayName;
        }

        public void setDomainDisplayName(String domainDisplayName) {
            this.domainDisplayName = domainDisplayName;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public List<Method> getMethods() {
            return methods;
        }

        public void setMethods(List<Method> methods) {
            this.methods = methods;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMatchUrl() {
            return matchUrl;
        }

        public void setMatchUrl(String matchUrl) {
            this.matchUrl = matchUrl;
        }

        public Boolean getSysHas() {
            return sysHas;
        }

        public void setSysHas(Boolean sysHas) {
            this.sysHas = sysHas;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getMenuUrl() {
            return menuUrl;
        }

        public void setMenuUrl(String menuUrl) {
            this.menuUrl = menuUrl;
        }

        public Integer getSort() {
            return sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }
    }
    class Method{
        private Integer id;
        private String name;
        private String url;
        private Boolean sysHas;
        private String memo;
        private Integer sort;
        private String matchUrl;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Boolean getSysHas() {
            return sysHas;
        }

        public void setSysHas(Boolean sysHas) {
            this.sysHas = sysHas;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Integer getSort() {
            return sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }

        public String getMatchUrl() {
            return matchUrl;
        }

        public void setMatchUrl(String matchUrl) {
            this.matchUrl = matchUrl;
        }
    }
    List<Controller> getClassMethod();

    class SetControllerParam{
        private Integer id;
        private String memo;
        private String matchUrl;
        private String domain;
        private String model;

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getMatchUrl() {
            return matchUrl;
        }

        public void setMatchUrl(String matchUrl) {
            this.matchUrl = matchUrl;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }
    void setController(SetControllerParam param);

    void changeControllerSort(Integer controllerId, Integer changeSort);

    void delController(Integer controllerid);

    class SetControllerMethodParam{
        private Integer id;
        private String memo;

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
    void setControllerMethod(SetControllerMethodParam param);
    void changeControllerMethodSort(Integer controllerMethodId, Integer changeSort);

    void delControllerMethod(Integer controllerMethodId);

    class Domain{
        private String name;
        private String displayName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }
    List<Domain> getDomain();
}
