package br.com.yaw.ssjpac.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import br.com.yaw.ssjpac.action.AbstractAction;
import br.com.yaw.ssjpac.event.AbstractEvent;
import br.com.yaw.ssjpac.event.AbstractEventListener;

public abstract class AbstractController implements ActionListener, WindowListener {

	private static Logger log = Logger.getLogger(AbstractController.class);
	
	private AbstractController parent;
	
	private Map<String, AbstractAction> actions = 
			new HashMap<String, AbstractAction>();
	
	private Map<Class<?>, List<AbstractEventListener<?>>> eventListeners = 
			new HashMap<Class<?>, List<AbstractEventListener<?>>>();
	
	public AbstractController(){}
	
	public AbstractController(AbstractController parent){
		if (parent != null) {
			this.parent = parent;
		}
	}
	

	protected void registerAction(AbstractButton source, AbstractAction action) {
		if (source.getActionCommand() == null) {
			throw new RuntimeException("Component (Button) without defined action!");
		}
		log.debug("Registering action: " + action.getClass().getName() + " for the button: " + source.getText());
        source.addActionListener(this);
        this.actions.put(source.getActionCommand(), action);
    }
	

	@SuppressWarnings("unchecked")
	protected void fireEvent(AbstractEvent<?> event) {
		if (eventListeners.get(event.getClass()) != null) {
            for (AbstractEventListener eventListener : eventListeners.get(event.getClass())) {
                log.debug("Evento: " + event.getClass().getName() + " com listener: " + eventListener.getClass().getName());
                eventListener.handleEvent(event);
            }
        }
		if (parent != null)
			parent.fireEvent(event);
	}
	
	protected void registerEventListener(Class<?> eventClass, AbstractEventListener<?> eventListener) {
        log.debug("Registering listener: " + eventListener + " to the event: " + eventClass.getName());
        java.util.List<AbstractEventListener<?>> listenersForEvent = eventListeners.get(eventClass);
        if (listenersForEvent == null) {
        	listenersForEvent = new ArrayList<AbstractEventListener<?>>(); 
        }
        listenersForEvent.add(eventListener);
        eventListeners.put(eventClass, listenersForEvent);
    }
	
	protected AbstractAction getAction(ActionEvent actionEvent) {
		AbstractButton button = (AbstractButton) actionEvent.getSource();
		String actionCommand = button.getActionCommand();
		return actions.get(actionCommand);
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			AbstractAction action = getAction(actionEvent);

			if (action != null) {
				log.debug("Running action: " + action.getClass());
				try {
					action.actionPerformed();
				} catch (Exception ex) {
					handlerException(ex);
				}
			}
		} catch (ClassCastException e) {
			handlerException(new IllegalArgumentException("Action source is not a AbstractButton: " + actionEvent));
		}
	}

	protected void handlerException(Exception ex) {
		log.error(ex);
		JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public AbstractController getParentController() {
        return parent;
    }
	
	protected void cleanUp() {}
	
	public void windowClosing(WindowEvent windowEvent) { 
		cleanUp(); 
	}
	
    public void windowOpened(WindowEvent windowEvent) {}
    public void windowClosed(WindowEvent windowEvent) {}
    public void windowIconified(WindowEvent windowEvent) {}
    public void windowDeiconified(WindowEvent windowEvent) {}
    public void windowActivated(WindowEvent windowEvent) {}
    public void windowDeactivated(WindowEvent windowEvent) {}
    
}
