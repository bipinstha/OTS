package us.edu.mum.ots.web.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 *
 * @author bipin
 */
public class ViewScope implements Scope, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
            Map<String, Object> viewMap = FacesContext.getCurrentInstance()
                    .getViewRoot().getViewMap();
            if (viewMap.containsKey(name)) {
                Object object = viewMap.get(name);
                this.context.getAutowireCapableBeanFactory().autowireBean(
                        object);
                return object;
            } else {
                Object object = objectFactory.getObject();
                viewMap.put(name, object);
                this.context.getAutowireCapableBeanFactory().autowireBean(
                        object);
                return object;
            }
        } else {
            return null;
        }
    }

    @Override
    public Object remove(String name) {
        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
            return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
                    .remove(name);
        } else {
            return null;
        }
    }

    @Override
    public String getConversationId() {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Not supported
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        this.context = ac;
    }
}
