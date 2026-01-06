@echo off
chcp 65001 > nul
title Lancement Micro-services E-bulltin

echo ========================================
echo  Lancement des micro-services Spring Boot
echo ========================================

:: Liste des services dans l'ordre de démarrage 
set SERVICES=ms-config ms-discovery etudiant2023 livre2023 emprunt2023 ms-gateway

:: Pour chaque service
for %%s in (%SERVICES%) do (
    echo.
    echo Démarrage de %%s...
    
    if exist "%%s\pom.xml" (
        start "%%s" cmd /c "cd /d "%%s" && mvn spring-boot:run > "..\%%s.log" 2>&1"
        timeout /t 8 /nobreak > nul
        echo ✓ %%s démarré
    ) else (
        echo ✗ %%s : pom.xml introuvable
    )
)

echo.
echo ========================================
echo  Tous les services sont en cours de démarrage
echo ========================================
echo.
echo Fichiers de logs créés :
dir *.log /b
echo.
echo Pour arrêter tous les services, fermez les fenêtres cmd ouvertes
echo ou appuyez sur Ctrl+C dans chaque fenêtre
echo. 
pause >nul

:: Nettoyage à la fermeture (tuer tous les mvn lancés)
echo Arrêt de tous les micro-services...
taskkill /F /T /IM mvn.cmd >nul 2>&1
taskkill /F /T /IM java.exe >nul 2>&1

echo Tous les services sont arrêtés.
timeout /t 2 >nul
 

@REM  http://localhost:8085/emprunt2023/emprunts
@REM  http://localhost:2025/emprunts