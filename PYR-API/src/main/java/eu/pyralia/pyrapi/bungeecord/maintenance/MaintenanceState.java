package eu.pyralia.pyrapi.bungeecord.maintenance;

/*    */
/*    */ public enum MaintenanceState
        /*    */ {
    /*  5 */   PUBLIC(0, "§a§lServices disponible au public ...", (short)0, true, true),
    /*  6 */   IN_UPDATE(1, "§c§lMaintenance en cours ...", (short)0, false, true),
    /*  7 */   PRIVATE_STAFF(2, "§c§lMaintenance en cours ...", (short)0, false, true),
    /*  8 */   CLOSE(3, "§c§lMaintenance en cours ...", (short)0, false, false),
    /*  9 */   OPEN_BUNGEE(4, "§b§lV3 DISPONIBLE ! Rejoignez nous dès maintenant !", (short)0, true, true),
    /* 10 */   MAINTENANCE_BUNGEE(5, "     §c§lServeur en cours de maintenance !", (short)0, false, true),
    /* 11 */   CLOSED_BETA_BUNGEE(6, "     §d§oMembres de la bêta privée uniquement", (short)0, false, true),
    /* 12 */   V3_INCOMING_BUNGEE(7, "§e§oLa V3 est en cours de préparation", (short)0, false, true);
    /*    */
    /*    */   private String message;
    /*    */
    /*    */   private int id;
    /*    */
    /*    */   private boolean joinablePublic;
    /*    */   private boolean joinableStaff;
    /*    */   private short glassColor;
    /*    */
    /*    */   MaintenanceState(int id, String message, short GlassColor, boolean joinablePublic, boolean joinableStaff) {
        /* 23 */     this.id = id;
        /* 24 */     this.message = message;
        /* 25 */     this.glassColor = GlassColor;
        /* 26 */     this.joinablePublic = joinablePublic;
        /* 27 */     this.joinableStaff = joinableStaff;
        /*    */   }
    /*    */
    /*    */
    /*    */   public String getMessage() {
        /* 32 */     return this.message;
        /*    */   }
    /*    */
    /*    */   public int getId() {
        /* 36 */     return this.id;
        /*    */   }
    /*    */
    /*    */   public boolean isJoinablePublic() {
        /* 40 */     return this.joinablePublic;
        /*    */   }
    /*    */
    /*    */   public boolean isJoinableStaff() {
        /* 44 */     return this.joinableStaff;
        /*    */   }
    /*    */
    /*    */   public short getGlassColor() {
        /* 48 */     return this.glassColor;
        /*    */   }
    /*    */
    /*    */   public static MaintenanceState getByID(int status) {
        /* 52 */     for (MaintenanceState system : values()) {
            /* 53 */       if (system.id == status) {
                /* 54 */         return system;
                /*    */       }
            /*    */     }
        /* 57 */     return null;
        /*    */   }
    /*    */ }


/* Location:              C:\Users\kphre\Downloads\ELT-API.jar!\fr\elity\commun\serveur\maintenance\MaintenanceState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
