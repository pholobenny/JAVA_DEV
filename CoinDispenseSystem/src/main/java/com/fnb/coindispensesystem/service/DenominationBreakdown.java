package com.fnb.coindispensesystem.service;
/**
 * 
 * Interface class for Dinomination breackdown
 * @author Benny Pholo
 */
import java.math.BigDecimal;
import java.util.List;

import com.fnb.coindispensesystem.model.NotesBreackdown;

public interface DenominationBreakdown {

	public List<NotesBreackdown> calculateDenomination(BigDecimal notes);
}
