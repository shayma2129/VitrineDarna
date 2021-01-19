package com.darna.services.impl;

import java.util.Calendar;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.darna.models.Action;
import com.darna.models.Notification;
import com.darna.repository.ActionRepository;
import com.darna.services.ActionService;
import com.darna.services.NotificationService;

@Service
public class ActionServiceImpl implements ActionService {
	
	@Autowired 
	private ActionRepository actionRepository;
	@Autowired 
	private NotificationService notificationService;
	
	@Transactional
	@Override
	public Action addAction(Action action) {
		action.setEtat_action(false);
		return actionRepository.save(action);
	}
	@Transactional
	@Override
	public Action updateAction(Action action, long idaction_old) {
		Action old_action=getActionById(idaction_old);
		action.setId_Action(idaction_old);
		action.setEtat_action(old_action.getEtat_action());
		return actionRepository.save(action);
	}
	@Transactional
	@Override
	public Action getActionById(long idact) {
		return actionRepository.findById(idact).get();
	}
	@Transactional
	@Override
	public void deleteAction(long id) {
		actionRepository.deleteById(id);
	}
	@Transactional
	@Override
	public List<Action> getAllAction() {
		List<Action> listAction=(List<Action>) actionRepository.findAll();
		 Calendar c = Calendar.getInstance();  
		 int currentDay=c.get(Calendar.DAY_OF_MONTH);
         
		for(Action action: listAction) {
			long nbmembre=action.getNbmembre_action();
			long nbnecessaire=action.getNbmembrefixe_action();
			long debutinscription=action.getDatedebut_inscrit().getTimeInMillis();
			long fininscription=action.getDatefin_inscrit().getTimeInMillis();
			/*== 
			 * Periode d'inscription
			 *  ==*/
			long periode=(((fininscription-debutinscription) / (1000 * 60 * 60 * 24))% 365)/2;
			System.out.println("période:"+periode);
			int fininscriptionday=action.getDatefin_inscrit().get(Calendar.DAY_OF_MONTH);
            long difference=fininscriptionday-periode;
            System.out.println("diif"+difference);
            System.out.println("curent"+currentDay);
			

			if((nbmembre<nbnecessaire)||(difference<=currentDay) ) {
				Notification notif=new Notification("Le nombre des membres n'est pas atteint",action);
				notificationService.addNotification(notif);
			}
			}
		
		return listAction;
	}
	@Transactional
	@Override
	public Action publierAction(Long idAction,boolean etat) {
		Action action=getActionById(idAction);
		action.setId_Action(idAction);
		action.setEtat_action(etat);
		return actionRepository.save(action);
	}

}
