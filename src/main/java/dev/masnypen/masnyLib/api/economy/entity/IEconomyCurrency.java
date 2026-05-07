package dev.masnypen.masnyLib.api.economy.entity;

public interface IEconomyCurrency {

    /**
     * Gets the currency symbol.
     *
     * @return the currency symbol (e.g., "$", "€")
     */
    String getSymbol();

    /**
     * Gets the full name of the currency.
     *
     * @return the currency name (e.g., "Dollar", "Euro")
     */

    String getName();

    /**
     * Formats the given amount according to the currency's format.
     *
     * @param amount the amount to format
     * @return formatted string representation of the amount (e.g., "$1,234.56")
     */
    String format(double amount);
}
