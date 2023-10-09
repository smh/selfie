<#import "source_set_selector.ftl" as source_set_selector>
<#macro display>
<nav class="navigation" id="navigation-wrapper">
    <div class="navigation--inner">
        <div class="navigation-title">
            <button class="menu-toggle" id="menu-toggle" type="button">toggle menu</button>
            <div class="library-name">
                <@template_cmd name="pathToRoot">
                    <a class="library-name--link" href="${pathToRoot}index.html">
                        <@template_cmd name="projectName">
                            ${projectName}
                        </@template_cmd>
                    </a>
                </@template_cmd>
            </div>
            <div class="library-version">
                <#-- This can be handled by the versioning plugin -->
                <@version/>
            </div>
        </div>
        <@source_set_selector.display/>
    </div>
    <div class="navigation-controls">
        <button class="navigation-controls--btn navigation-controls--theme" id="theme-toggle-button" type="button">switch theme</button>
        <div class="navigation-controls--btn navigation-controls--search" id="searchBar" role="button">search in API</div>
    </div>
</nav>
<div class="selfie-container">
    <div class="selfie-sidebar-spacer"></div>
    <div class="selfie-main">
        <div class="selfie-main-content">
            <img src="../../images/antique_humanoid.webp" class="selfie-navigation-bot"/>
        </div>
    </div>
</div>
</#macro>